import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ApiServices } from './http/api.services';
import { Constants } from './constants/constants';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule, MatToolbarModule, MatDialogModule, MatButtonModule,MatTableModule } from '@angular/material';
import { AddProductDialogComponent } from './add-product-dialog/add-product-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    AddProductDialogComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatCardModule,
    MatToolbarModule,
    FormsModule,
    MatDialogModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatTableModule
  ],
  exports:[MatTableModule],
  providers: [ApiServices, Constants],
  bootstrap: [AppComponent],
  entryComponents: [AddProductDialogComponent]
})
export class AppModule { }
