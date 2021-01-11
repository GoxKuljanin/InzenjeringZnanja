import { Test } from './../../modeli/test';
import { Pregled } from './../../modeli/pregled';
import { ZdravstveniKarton } from './../../modeli/zdravstveni-karton';
import { Pacijent } from './../../modeli/pacijent';
import { Simptom } from './../../modeli/simptom';
import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-unesi-simptome-dialog',
  templateUrl: './unesi-simptome-dialog.component.html',
  styleUrls: ['./unesi-simptome-dialog.component.css']
})
export class UnesiSimptomeDialogComponent implements OnInit {

  selectedOptions = [];
  selectedOption: any;

  listOfSymptomsFromDatabase: Simptom[] = [];
  pacijentSimptomi: Simptom[] = [];

  listOfTests: Test[] = [];
  selectedTests: Test[] = [];
                      
  pregled: Pregled;
  karton: ZdravstveniKarton = new ZdravstveniKarton();

  constructor(public dialogRef: MatDialogRef<UnesiSimptomeDialogComponent>, @Inject(MAT_DIALOG_DATA) public model: any,
                private http: HttpClient) { }

  ngOnInit() {
    let simptoms = this.dobaviSimptome().subscribe(
      data => {
        this.listOfSymptomsFromDatabase = data;
      }
    );
  }
  
  onNgModelChange(event){
    this.pacijentSimptomi = event;
  }
  //Za cuvanje testova u pregled
  onNgModelChangeTest(event){
    this.selectedTests = event;
  }

  dodajSimptomeCBR(){
    this.pregled = this.model;
    console.log(this.pacijentSimptomi);
    this.upisiSimptomeCBR(this.pacijentSimptomi, this.pregled.id).subscribe(
      data => {
        console.log(data);
        this.listOfTests = data;
      }
    );
  }
  dodajSimptomeRBR(){
    this.pregled = this.model;
    this.upisiSimptomeRBR(this.pacijentSimptomi, this.pregled.id).subscribe(
      data => {
        this.listOfTests = data;
      }
    );
  }

  upisiSimptome(){
    this.pregled = this.model;
    this.pregled.simptomi = this.pacijentSimptomi;
    this.pregled.testovi = this.selectedTests;
    console.log(this.selectedTests)
    this.upisiTestove(this.selectedTests, this.pregled.id).subscribe(
      data => {
        console.log('Uspesno sacuvani testovi');
        this.dialogRef.close(this.pregled);
      }
    );
  }

  sviTestovi(){
    this.dobaviSveTestovi().subscribe(
      data => {
        this.listOfTests = data;
      }
    );
  }

  dobaviSveTestovi():Observable<Test[]>{
    return this.http.get<Test[]>('http://localhost:8089/dijagnoza/getAllTestovi');
  }

  upisiTestove(testovi, id:number):Observable<any>{                       //id pregleda
    return this.http.post('http://localhost:8089/pregled/test/' + id, testovi);
  }

  upisiSimptomeCBR(newSimptomi, id:number):Observable<any>{
    return this.http.post('http://localhost:8089/pregled/cbr/' + id, newSimptomi);
  }

  upisiSimptomeRBR(newSimptomi, id:number):Observable<any>{
    return this.http.post('http://localhost:8089/pregled/rbr/' + id, newSimptomi);
  }

  dobaviSimptome(): Observable<Simptom[]>{
    return this.http.get<Simptom[]>('http://localhost:8089/pregled/simptom');
  }

  validateSavucaj(){
    return this.selectedTests.length!=0?true:false;
  }
  validatePronadji(){
    return this.pacijentSimptomi.length!=0?true:false;
  }
}
