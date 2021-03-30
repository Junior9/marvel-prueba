import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { MarvelService } from './../../service/marvel.service';

declare var $:any;

@Component({
  selector: 'app-heroe',
  templateUrl: './heroe.component.html',
  styleUrls: ['./heroe.component.scss']
})
export class HeroeComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private marvelService:MarvelService) { }
  id:string="";
  msnError:string="";
  showDetalles:boolean = true;
  pageErrorMsn:any={
    comicsError:''
  }
  heroe:any={
    img:'assets/img/no-found.png',
    name:'',
    description:'',
    comics:[],
    lastUpdate:''
  }
  comics:any=[];


  ngOnInit(): void {

    this.route.paramMap.subscribe(param => {
      if (param.has('id')){
        this.id = param.get('id');
        this.marvelService.getCharactersById(this.id).subscribe(resp=>{
          if(resp['code'] == 200){
            let heroeData = resp['data']['results'];
            //console.log(heroeData[0]) 
            this.heroe.name = heroeData[0].name;
            this.heroe.img = heroeData[0].thumbnail.path + "." + heroeData[0].thumbnail.extension;
            this.heroe.description = heroeData[0].description;
            this.heroe.lastUpdate = heroeData[0].modified;

            //this.heroe.comics = heroeData[0].comics.items;

            this.marvelService.getComicsByCharacterId(this.id).subscribe(respComics=>{
            
              if(respComics['code'] == 200){
                let dataComics = respComics['data']['results'];
                dataComics.forEach(element => {
                  this.heroe.comics.push(element);
                });
              }else{
                this.pageErrorMsn.comicsError = "Erro al cargar lis de comics"
              }
            })

          }else{
            //modal Error
            this.msnError = resp['status'];
            $("#modalError").modal('show')
          }
        },error=>{
            console.error(error)
            this.msnError = error['error']['status'];
            this.heroe.name = "Heroe no encontrado";
            this.showDetalles = false;
            $("#modalError").modal('show')
        })
      }else{
        this.router.navigate(['/']);
      }
    });
  }
}