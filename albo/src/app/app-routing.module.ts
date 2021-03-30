import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeroeComponent } from './pages/heroe/heroe.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { SincronizacionComponent } from './pages/sincronizacion/sincronizacion.component';
import { ComicComponent } from './pages/comic/comic.component'

const routes: Routes = [
  {path:'',component:InicioComponent},
  {path:'heroe/:id', component:HeroeComponent},
  {path:'registradatos', component:SincronizacionComponent},
  {path:'comic/:id',component:ComicComponent},
  {path:'404',component:PageNotFoundComponent},
  {path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
