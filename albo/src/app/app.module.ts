import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './pages/inicio/inicio.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeroeComponent } from './pages/heroe/heroe.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { SincronizacionComponent } from './pages/sincronizacion/sincronizacion.component';
import { FormsModule ,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { ComicComponent } from './pages/comic/comic.component';
import { CreatorComponent } from './pages/creator/creator.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    HeaderComponent,
    FooterComponent,
    HeroeComponent,
    PageNotFoundComponent,
    SincronizacionComponent,
    ComicComponent,
    CreatorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
