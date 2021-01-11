import { Component, OnInit, Inject } from '@angular/core';
import { Lek } from 'src/app/modeli/lek.model';
import { Dijagnoza } from 'src/app/modeli/dijagnoza.model';
import { Pacijent } from 'src/app/modeli/pacijent';
import { ZdravstveniKarton } from 'src/app/modeli/zdravstveni-karton';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Test } from 'src/app/modeli/test';
import {Pregled} from "../../modeli/pregled";

@Component({
  selector: 'app-unesi-testove-dialog',
  templateUrl: './unesi-testove-dialog.component.html',
  styleUrls: ['./unesi-testove-dialog.component.css']
})
export class UnesiTestoveDialogComponent implements OnInit {

  selectedOptions = [];
  selectedOption: any;

  listaSvihTestova: Test[] = [];
  odbraniTestovi: Test[] = [];

  listaDijagnoza: Dijagnoza[] = [];
  odabraneDijagnoze: Dijagnoza[] = [];

  pregled: Pregled;
  karton: ZdravstveniKarton = new ZdravstveniKarton();

  constructor(public dialogRef: MatDialogRef<UnesiTestoveDialogComponent>, @Inject(MAT_DIALOG_DATA) public model: any,
              private http: HttpClient) {
    // this.dobaviTestove().subscribe(
    //   data => {
    //     this.listaSvihTestova = data;
    //   }
    // );
  }

  ngOnInit() {
    this.listaSvihTestova = this.model.testovi;
    // let tests = this.dobaviTestove().subscribe(
    //   data => {
    //     this.listaSvihTestova = data;
    //   }
    // );
  }

  onNgModelChange(event){
    this.odbraniTestovi = event;
  }

  //za cuvanje dijagnoza u pregled
  onNgModelChangeDijagnoza(event){
    this.odabraneDijagnoze = event;
    console.log(this.odabraneDijagnoze);
  }

  dodajTestoveCBR(){
    this.pregled = this.model;
    console.log(this.odbraniTestovi);
    this.upisiTestoveCBR(this.odbraniTestovi, this.pregled.id).subscribe(
      data => {
        this.listaDijagnoza = data;
        console.log(this.listaDijagnoza);
      }
    );
  }

  dodajTestoveRBR(){
    this.pregled = this.model;
    this.upisiTestoveRBR(this.odbraniTestovi, this.pregled.id).subscribe(
      data => {
        this.listaDijagnoza = data;
        console.log("RBR");
        console.log(this.listaDijagnoza);
      }
    );
  }

  upisiTestove(){
    this.pregled = this.model;
    this.pregled.dijagnoze = this.odabraneDijagnoze;
    this.pregled.testovi = this.odbraniTestovi
    console.log(this.odabraneDijagnoze);
    this.upisiDijagnoze(this.odabraneDijagnoze, this.pregled.id).subscribe(
      data => {
        console.log('Uspesno sacuvane dijagnoze.');
        this.dialogRef.close(this.pregled);
      }
    );
  }

  upisiDijagnoze(dijagnoze, id:number):Observable<any>{                       //id pregleda
    return this.http.post('http://localhost:8089/dijagnoza/saveDijagnoze/' + id, dijagnoze);
  }

  upisiTestoveCBR(newTestovi, id:number):Observable<any>{
    return this.http.post('http://localhost:8089/dijagnoza/cbr/' + id, newTestovi);
  }

  upisiTestoveRBR(newTestovi, id:number):Observable<any>{
    return this.http.post('http://localhost:8089/dijagnoza/rbr/' + id, newTestovi);
  }
  
  validateSavucaj(){
    return this.listaDijagnoza.length!=0?true:false;
  }
  validatePronadji(){
    return this.odbraniTestovi.length!=0?true:false;
  }
  validateListuTestova(){
    return this.listaSvihTestova.length!=0?true:false;
  }
}
