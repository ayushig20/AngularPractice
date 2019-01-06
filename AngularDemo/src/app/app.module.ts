import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { AppComponent } from './app.component';
import { ApiServices } from './http/api.services';
import { Constants } from './constants/constants';
import { MatCardModule,MatToolbarModule } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatCardModule,
    MatToolbarModule
  ],
  providers: [ApiServices,Constants],
  bootstrap: [AppComponent]
})
export class AppModule { }
