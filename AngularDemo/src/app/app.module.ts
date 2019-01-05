import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { AppComponent } from './app.component';
import { ApiServices } from './http/api.services';
import { Constants } from './constants/constants'

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ApiServices,Constants],
  bootstrap: [AppComponent]
})
export class AppModule { }
