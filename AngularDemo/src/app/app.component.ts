import { Component, OnInit, Injectable } from '@angular/core';
//Import class to be used
import { ApiServices } from './http/api.services';
import { Constants } from './constants/constants';


@Component({
  selector: 'app-root',
  providers : [ApiServices,Constants],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit{
productData = undefined;
productList = [];
title = 'YourCart';
//_url = '';

ngOnInit():any{

//Load all products initially
// var productList = this.apiServices.GetData(this.constants.PRODUCT_SERVICES.GET_PRODUCTS_LIST);
this.productList = [{'id':1,'name':'Product1','type':'Type1'},{'id':1,'name':'Product2','type':'Type2'},{'id':1,'name':'Product3','type':'Type3'}];
 console.log(this.productList);
}

constructor(private apiServices: ApiServices,private constants: Constants) {  
}

//Get specific product details
viewProductDetails(productType: string): any{
  console.log('in viewProductDetails');
  var _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + productType;
  console.log(_url);
  this.productData = this.apiServices.GetData(_url);
  console.log(this.productData);
}

addProduct(addForm: any): any{
  console.log('in viewProductDetails');
  var postData = '';
  this.productData = this.apiServices.PostData(this.constants.PRODUCT_SERVICES.ADD_PRODUCT,postData);
  console.log(this.productData);
}
}

interface Product{
  id: BigInteger,
  name: string,
  type:string
}




