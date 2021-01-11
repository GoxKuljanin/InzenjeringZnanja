import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { NewPregled } from './../../../modeli/new-pregled';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Inject } from '@angular/core';

@Component({
  selector: 'app-pregled-dialog',
  templateUrl: './pregled-dialog.component.html',
  styleUrls: ['./pregled-dialog.component.css']
})
export class PregledDialogComponent implements OnInit {

  godina:number;
  tezina:number;

  newPregled : NewPregled = new NewPregled();
  kartonID: number;
  flag:number;

  constructor(private http: HttpClient, public dialogRef: MatDialogRef<PregledDialogComponent>, @Inject(MAT_DIALOG_DATA) public model: any) {
    this.kartonID = model.id;
    this.flag = model.flag;
   }

  ngOnInit() {
  }

  unesiPregled(){
    this.upisiPregled().subscribe(pregled => {
      this.dialogRef.close(pregled);
    });
  }

  upisiPregled(){
    this.newPregled.id = this.kartonID;
    this.newPregled.godina = this.godina;
    this.newPregled.tezina = this.tezina;
    return this.http.put('http://localhost:8089/pregled', this.newPregled);
  }
  disabledButton(){
    return this.godina==null||this.tezina==null?true:false;
  }

}
