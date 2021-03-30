import { Component, OnInit } from '@angular/core';
import { BuildService } from './../../service/build.service';
import { MarvelService } from './../../service/marvel.service';
import { SincronizaService } from './../../service/sincroniza.service';

declare var $:any;

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})
export class InicioComponent implements OnInit {
  
  
  constructor(private buildService:BuildService,private marvelService:MarvelService,private sincroService:SincronizaService) { }
  heroes:any=[];
  characters:any=[];
  msnError:string="";
  dateRelog:string="";
  hasTimer:Boolean=false;
  btnSinc:Boolean=false;
  loop:any;
  nombreCharacToFilterColabo:string='';
  nombreCharacToFilter:string='';
  sincronizaciones:any=[];
  pageResponse={
    title:"",
    json:{
      Character:'',
      last_sync:'',
      writers:[String],
      colorists:[String],
      editor:[String],
      penciller:[String]
    }
  }
  pageResponseCharacters={
    title:"",
    json:{
      last_sync:'',
      items:{},
    }
  }
  pageErrorMsn={
    nombreCharacterColaborator:'',
    nombreCharacterInteractor:'',
    requestErrorMsn:''
  }
  
  ngOnInit(): void {
    
    this.marvelService.getCharacters().subscribe(resp=>{
      let datos = resp['data']['results'];
      datos.forEach(heroeData => {
        this.heroes.push(heroeData);
      }); 
      
    },error=>{
      //Refactor
      console.error(error)
    })
    
    this.marvelService.getCharacterByDataBase().subscribe(respCha=>{
      this.characters = respCha;
    })
  
    this.updateSincro();
  }
  
  getColaboarators(){
    this.resetErrorMsn();
    
    if(this.sincronizaciones.length > 0){
      if(this.nombreCharacToFilterColabo != ''){
        $("#modal").modal("show");
        this.marvelService.getColaboaratorsByCharacterName(this.nombreCharacToFilterColabo).subscribe(resp=>{
          this.pageResponse.title = "Editores, escritores y coloristas que han estado involucrados con " +this.nombreCharacToFilterColabo;
          this.pageResponse.json.Character = resp['Character'];
          this.pageResponse.json.colorists = resp['colorists'];
          this.pageResponse.json.editor = resp['editor'];
          this.pageResponse.json.penciller = resp['penciller'];
          this.pageResponse.json.writers = resp['writers'];
          this.pageResponse.json.last_sync = resp['last_sync'];
          
          $("#modal").modal("hide");
          $("#modalResponse").modal("show")
        },error=>{
          console.error(error)
          this.pageErrorMsn.requestErrorMsn = error.message;
          $("#modal").modal("hide");
          $("#modalError").modal("show")
        })
      }else{
        this.pageErrorMsn.nombreCharacterColaborator = "Selecciona el nombre de un heroe de Marvel";
      }
    }else{
      this.pageErrorMsn.requestErrorMsn = "Haz la sincronización de la base de datos antes";
      $("#modal").modal("hide");
      $("#modalSincroniza").modal("show")
    }
  } 
  
  getCharacteresInteraction(){
    this.resetErrorMsn();
  
    if(this.sincronizaciones.length > 0){
      if(this.nombreCharacToFilter != ''){
        $("#modal").modal("show");
        this.marvelService.getCharacteresInteractionByCharacterName(this.nombreCharacToFilter).subscribe(resp=>{
          
          let list = resp['result'];
          let lastSyc = resp['last_sync'];

          this.pageResponseCharacters.title = "Characteres que interacturon con el "+ this.nombreCharacToFilter;
          this.pageResponseCharacters.json.last_sync = lastSyc;
          this.pageResponseCharacters.json.items = list;

          console.log(this.pageResponseCharacters)

          $("#modal").modal("hide");
          $("#modalResponse2").modal("show")
        },error=>{
          console.error(error)
          this.pageErrorMsn.requestErrorMsn = error.message;
          $("#modal").modal("hide");
          $("#modalError").modal("show")
        })
      }else{
        this.pageErrorMsn.nombreCharacterInteractor = "Escriba el nombre de un heroe de Marvel";
      }
    }else{
      this.pageErrorMsn.requestErrorMsn = "Haz la sincronización de la base de datos antes";
      $("#modal").modal("hide");
      $("#modalSincroniza").modal("show")
    }
  }
  
  sincronizar(showModal:Boolean=false){
    
    if(!showModal){
      $("#modal").modal("show");
    }
    
    this.marvelService.getCharacters().subscribe(respCharacters=>{
      //console.log("Characters",respCharacters['data']['results'])

      this.marvelService.getComics().subscribe(respComics=>{
        
        this.marvelService.getCreators().subscribe(respCreatoes=>{
          //console.log("Creators",respCreatoes['data']['results'])
          
          
          this.sincroService.sincronizar({"comics":respComics['data']['results'],"creators":respCreatoes['data']['results'],"characteres":respCharacters['data']['results']}).subscribe(resp=>{
            //console.log(resp)
            if(!showModal){
              this.marvelService.getCharacterByDataBase().subscribe(respCha=>{
                this.characters = respCha;
              })
              this.updateSincro();
              $("#modal").modal("hide");
            }else{
              this.marvelService.getCharacterByDataBase().subscribe(respCha=>{
                this.characters = respCha;
              })
              this.updateSincro();
              $("#modalSincroniza").modal("hide");
            }
            
          },error=>{
            $("#modal").modal("hide");
            $("#modalSincroniza").modal("hide");
            $("#modalSincronizaError").modal("show");
            this.pageErrorMsn.requestErrorMsn = "Servido fuera de servicio"
          })
        })
      })
      
    },error=>{
      console.error(error)
    })
    
  }
  
  agendar(){
    
    const today = new Date()
    var tomorrow = new Date(today)
    tomorrow.setDate(tomorrow.getDate() + 1)
    this.setTimer(tomorrow);
    this.hasTimer = true;
    this.btnSinc = true;

    this.sincroService.agendar().subscribe(respAgenda=>{
      console.log(respAgenda)
    })    

  }
  
  editarTimer(){
    this.setTimer(new Date(this.dateRelog))
  }
  
  cancelar(){
    this.btnSinc = false;
    
    document.getElementById("demo").innerHTML =  0 + "h "
    + 0 + "m " + 0 + "s ";
    
    clearInterval(this.loop);
  }
  
  private resetErrorMsn(){
    this.pageErrorMsn.nombreCharacterColaborator = "";
    this.pageErrorMsn.nombreCharacterInteractor = "";
    this.pageErrorMsn.requestErrorMsn = "";
  }
  
  
  private setTimer(tomorrow:Date){
    
    //document.getElementById("demo").innerHTML = "";
    this.loop = setInterval(function() {
      var now = new Date().getTime();
      var distance = tomorrow.getTime() - now;
      var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
      var seconds = Math.floor((distance % (1000 * 60)) / 1000);
      
      document.getElementById("demo").innerHTML =  hours + "h "
      + minutes + "m " + seconds + "s ";
      if (distance < 0) {
        clearInterval(this.loop);
        document.getElementById("demo").innerHTML = "Actualizando";
        
        this.updateSincro();
      }
      
      
    },1000);
    
    
    
  }
  
  private updateSincro(){
    this.sincroService.getSincronizaciones().subscribe(resp=>{
      let result:any = resp.valueOf();
      result.forEach(element => {
        this.sincronizaciones.push(element)
      });
    },error=>{
      $("#modalSincronizaError").modal("show");
      this.pageErrorMsn.requestErrorMsn = "Servidor fuera de servicio : " + error.message;
    })
  } 
  
}
