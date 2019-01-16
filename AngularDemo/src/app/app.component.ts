import { Component, OnInit, ViewChild } from '@angular/core';
//Import class to be used
import { ApiServices } from './http/api.services';
import { Constants } from './constants/constants';
import { MatDialog, MatSort, MatTableDataSource } from '@angular/material';
import { AddProductDialogComponent } from './add-product-dialog/add-product-dialog.component';

export interface Product {
  id: any;
  name: string;
  type: string
}

@Component({
  selector: 'app-root',
  providers: [ApiServices, Constants],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  //Grid Column names
  displayedColumns: string[] = ['id', 'name', 'type', 'view', 'delete'];
  dataSource: MatTableDataSource<Product>;
  typeOptions = [];
  title = 'YourCart';
  typeOptionSelected: any;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private apiServices: ApiServices, private constants: Constants, public dialog: MatDialog) {
  }

  ngOnInit(): any {
    //Initialize Type dropdown values
    this.typeOptions = ['ALL', 'SOAP', 'SHAMPOO', 'DETERGENT POWDER'];
    //By default keep the selected item as ALL  
    this.typeOptionSelected = 'ALL';

    this.dataSource = new MatTableDataSource();

    //Call all product list on page load
    this.viewAllProductList();
  }

  onTypeOptionSelected(selectedTypeOption: any) {
    this.typeOptionSelected = selectedTypeOption;

    //Call viewProductListBasedOnType
    this.viewProductListBasedOnType(this.typeOptionSelected);
  }

  public doFilter = (value: string) => {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }
  
  //Get all product details
  //For now, calling getproduct on type basis for all type seperately
  viewAllProductList(): any {
    var _url = '';
    //Load all products initially
    // var productList = this.apiServices.GetData(this.constants.PRODUCT_SERVICES.GET_PRODUCTS_LIST);
    _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + "SOAP";
    this.apiServices.GetData(_url).subscribe((res: any) => {
      var productListDB = res;
      let productList = [];
      // console.log(productListDB);
      for (var i = 0; i < productListDB.length; i++) {
        productList.push(productListDB[i]);
      }

      //Fetch again
      _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + "SHAMPOO";
      this.apiServices.GetData(_url).subscribe((res: any) => {
        var productListDB = res;
        // console.log(productListDB);
        for (var j = 0; j < productListDB.length; j++) {
          productList.push(productListDB[j]);
        }

        //Fetch again
        _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + "DETERGENT POWDER";
        this.apiServices.GetData(_url).subscribe((res: any) => {
          var productListDB = res;
          // console.log(productListDB);
          for (var k = 0; k < productListDB.length; k++) {
            productList.push(productListDB[k]);
          }

          //Setting datasource from product list
          this.dataSource = new MatTableDataSource(productList);
          this.dataSource.sort = this.sort;
          console.log(this.dataSource);
        });
      });
    });
  }
  //Get specific product details
  viewProductListBasedOnType(productType: string): any {
    if (this.typeOptionSelected === 'ALL')
      this.viewAllProductList();
    else {
      var _url = this.constants.PRODUCT_SERVICES.GET_PRODUCT_DETAILS + productType;
      this.apiServices.GetData(_url).subscribe((res: any) => {
        var productListDB = res;
        let productList = [];
        // console.log(productListDB);

        for (var k = 0; k < productListDB.length; k++) {
          productList.push(productListDB[k]);
        }

        this.dataSource = new MatTableDataSource(productList);
        this.dataSource.sort = this.sort;
        console.log(this.dataSource);
      });
    }
  }

  openAddProductDialog(): any {
    let addDialogRef = this.dialog.open(AddProductDialogComponent, {
      width: '600px',
      data: 'Called from Main Page'
    });
    addDialogRef.afterClosed().subscribe(result => {
      if (result === 'confirm')
        //Refresh list will be done here
        this.viewAllProductList();
    });
  }

  deleteProduct(id: any): any {
    console.log('Delete product :'+id);
    var _url = this.constants.PRODUCT_SERVICES.DELETE_PRODUCT + id;
      this.apiServices.DeleteData(_url).subscribe((res: any) => {
        if(res){
          console.log('Product deleted');
          this.viewAllProductList();
        }else{
         console.log('Product not deleted');
        }
          
        
      });
  }

  viewProductDetails(id: any): any {

  }
}
