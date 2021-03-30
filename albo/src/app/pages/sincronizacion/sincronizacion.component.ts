import { Component, OnInit } from '@angular/core';
import { SincronizaService } from './../../service/sincroniza.service';

declare var $:any;

@Component({
  selector: 'app-sincronizacion',
  templateUrl: './sincronizacion.component.html',
  styleUrls: ['./sincronizacion.component.scss']
})
export class SincronizacionComponent implements OnInit {

  constructor(private sincroService:SincronizaService) { }

  ngOnInit(): void {

  }

  setPrueba(){
    this.sincroService.setDatosPrueba().subscribe(resp=>{
      console.log(resp)
      $("#modalOk").modal("show")
    })
  }

}
