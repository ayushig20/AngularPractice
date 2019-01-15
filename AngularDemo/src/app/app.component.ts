import { Component, OnInit, Injectable } from '@angular/core';
//Import class to be used
import { ApiServices } from './http/api.services';
import { Constants } from './constants/constants';
import { MatDialog } from '@angular/material';
import { AddProductDialogComponent } from './add-product-dialog/add-product-dialog.component';


@Component({
  selector: 'app-root',
  providers: [ApiServices, Constants],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {
  productData = undefined;
  productList = [];
  typeOptions = [];
  title = 'YourCart';

  typeOptionSelected: any;


  constructor(private apiServices: ApiServices, private constants: Constants, public dialog: MatDialog) {
  }

  ngOnInit(): any {
    //Initialize Type dropdown values
    this.typeOptions = ['ALL', 'SOAP', 'SHAMPOO', 'DETERGENT POWDER'];
    //By default keep the selected item as ALL  
    this.typeOptionSelected = 'ALL';
    //Call all product list on page load
    this.viewAllProductList();
  }

  onTypeOptionSelected(selectedTypeOption: any) {
    console.log(selectedTypeOption); //option value will be sent as event
    this.typeOptionSelected = selectedTypeOption;
    //Call viewProductListBasedOnType
    this.viewProductListBasedOnType(this.typeOptionSelected);
  }


  //Get all product details
  //For now, i am calling getproduct on type basis for all type explicitly
  viewAllProductList(): any {
    console.log('in viewAllProductList');
    var productListDB = [];
    this.productList = [];
    var _url = '';
    //Load all products initially
    // var productList = this.apiServices.GetData(this.constants.PRODUCT_SERVICES.GET_PRODUCTS_LIST);
    _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + "SOAP";
    this.apiServices.GetData(_url).subscribe((res: any) => {
      var productListDB = res;
      console.log(productListDB);
      for (var i = 0; i < productListDB.length; i++) {
        this.productList.push(productListDB[i]);
      }

      //Fetch again
      _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + "SHAMPOO";
      this.apiServices.GetData(_url).subscribe((res: any) => {
        var productListDB = res;
        console.log(productListDB);
        for (var j = 0; j < productListDB.length; j++) {
          this.productList.push(productListDB[j]);
        }

        //Fetch again
        _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + "DETERGENT POWDER";
        this.apiServices.GetData(_url).subscribe((res: any) => {
          var productListDB = res;
          console.log(productListDB);
          for (var k = 0; k < productListDB.length; k++) {
            this.productList.push(productListDB[k]);
          }

          console.log(this.productList);
        });
      });
    });
  }
  //Get specific product details
  viewProductListBasedOnType(productType: string): any {
    console.log('in viewProductListBasedOnType:' + productType);
    this.productList = [];

    if (this.typeOptionSelected === 'ALL')
      this.viewAllProductList();
    else {
      var _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + productType;
      this.apiServices.GetData(_url).subscribe((res: any) => {
        var productListDB = res;
        console.log(productListDB);

        for (var k = 0; k < productListDB.length; k++) {
          this.productList.push(productListDB[k]);
        }
      });
    }
  }

  openAddProductDialog(): any {
    let addDialogRef = this.dialog.open(AddProductDialogComponent, {
      width: '600px',
      data: 'Called from Main Page'
    });
    addDialogRef.afterClosed().subscribe(result => {
      if(result === 'confirm')
        this.viewAllProductList();
      //Refresh list will be done here
    });
  }

  // addProduct(addForm: any): any {
  //   console.log('in viewProductDetails');
  //   var postData = '';
  //   this.productData = this.apiServices.PostData(this.constants.PRODUCT_SERVICES.ADD_PRODUCT, postData);
  //   console.log(this.productData);
  // }
}
