import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MarvelService } from './../../service/marvel.service';

@Component({
  selector: 'app-comic',
  templateUrl: './comic.component.html',
  styleUrls: ['./comic.component.scss']
})
export class ComicComponent implements OnInit {

  constructor(private route: ActivatedRoute,private marvelService:MarvelService) { }

  id:string="";
  creator:any={
    fullName:'',
    thumbnail:{},
    urls:[{
      url:''
    }]
  }
  comic:any={
    title:"",
    thumbnail:{},
    creators:[]
  };

  ngOnInit(): void {
    this.route.paramMap.subscribe(param => {
      if (param.has('id')){
        this.id = param.get('id');
        this.marvelService.getComicById(this.id).subscribe(resp=>{
          if(resp['code'] == 200){
            this.comic = resp['data']['results'][0];
          }
        });
      }
    });
  }

  infoCreator(url:string){
    this.marvelService.getCreatorByLink(url).subscribe(resp=>{
      this.creator = resp['data']['results'][0];
      window.open(this.creator.urls[0].url);
    });
  }

}