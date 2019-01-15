import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ApiServices } from '../http/api.services';
import { Constants } from '../constants/constants';

@Component({
  selector: 'app-add-product-dialog',
  templateUrl: './add-product-dialog.component.html',
  styleUrls: ['./add-product-dialog.component.css']
})
export class AddProductDialogComponent implements OnInit {
  pName = undefined;
  pType = undefined;

  constructor(public thisDialogRef: MatDialogRef<AddProductDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: string, private apiServices: ApiServices, 
    private constants: Constants) { }

  ngOnInit() {
  }
  onCloseConfirm() {
    this.thisDialogRef.close('confirm');
  }

  addProduct(addForm: any): any {
    console.log('in viewProductDetails');
    var postData = {
      'productName': this.pName,
      'productType': this.pType
    };
    console.log(postData);
    this.apiServices.PostData(this.constants.PRODUCT_SERVICES.ADD_PRODUCT, postData)
      .subscribe((res: any) => {
        console.log(res);
        console.log('Product added successfully');
        this.onCloseConfirm();
      });

  }

  onCloseCancel() {
    this.thisDialogRef.close('cancel');
  }
}
