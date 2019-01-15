import { Component, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class ApiServices {
    protocol = 'https://';
    host = 'localhost:';
    port = '8443';
    head = new HttpHeaders({ 'Content-Type': 'application/json', 'Authorization': 'Basic ' + btoa("admin:admin") });

    constructor(private http: HttpClient) {
    }

    GetData(url: string): any {
        return this.http.get(this.protocol + this.host + this.port + url, { headers: this.head })
            .pipe(
                (res: any) => {
                    return res
                },
                (err: any) => { return err });

    }

    PostData(url: string, data: any): any {
        return this.http.post(this.protocol + this.host + this.port + url, data, { headers: this.head })
            .pipe(
                (response: any) => {
                    console.log(response);
                    return response;
                },
                (err: any) => { return err; });
    }
}