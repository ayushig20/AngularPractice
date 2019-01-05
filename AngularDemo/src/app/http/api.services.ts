import { Component, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class ApiServices {
    protocol = 'http://';
    host = 'localhost:';
    port = '9090';
    head = new HttpHeaders({ 'Content-Type': 'application/json' });

    constructor(private http: HttpClient) {
    }

    GetData(url: string): any {
        return this.http.get(this.protocol +this.host + this.port + url, { headers: this.head }).subscribe(
            getProductResponse => {
                console.log("Received data from API");
                console.log(getProductResponse);
            },
            err => {
                console.log("Error occured while hitting API");
            }
        );
    }

    PostData(): any {

        return this.http.post('http://localhost:9090/service/productservice/getproducts/Type1', { headers: this.head }).subscribe(
            getProductResponse => {
                console.log("Post call");
            },
            err => {
                console.log("Error occured while hitting API");
            }
        );
    }
}