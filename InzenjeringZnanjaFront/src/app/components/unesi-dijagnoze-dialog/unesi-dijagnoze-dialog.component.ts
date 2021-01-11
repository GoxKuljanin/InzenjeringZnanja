import { Component, OnInit, Inject } from '@angular/core';
import { Lek } from 'src/app/modeli/lek.model';
import { Dijagnoza } from 'src/app/modeli/dijagnoza.model';
import { Pacijent } from 'src/app/modeli/pacijent';
import { ZdravstveniKarton } from 'src/app/modeli/zdravstveni-karton';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pregled } from 'src/app/modeli/pregled';

@Component({
  selector: 'app-unesi-dijagnoze-dialog',
  templateUrl: './unesi-dijagnoze-dialog.component.html',
  styleUrls: ['./unesi-dijagnoze-dialog.component.css']
})
export class UnesiDijagnozeDialogComponent implements OnInit {

  selectedOptions = [];
  selectedOption: any;

  listaSvihDijagnoza: Dijagnoza[] = [];
  odbraneDijagnoze: Dijagnoza[] = [ ];

  listaLekova: Lek[] = [];
  odabraniLekovi: Lek[] = [];
                 
  pregled: Pregled = new Pregled();
  karton: ZdravstveniKarton = new ZdravstveniKarton();

  constructor(public dialogRef: MatDialogRef<UnesiDijagnozeDialogComponent>, @Inject(MAT_DIALOG_DATA) public model: any,
  private http: HttpClient) {
    this.pregled = model;
    console.log(this.odbraneDijagnoze);
    this.pregled.dijagnoze!=null?this.listaSvihDijagnoza = this.pregled.dijagnoze:null; 
    // this.dobaviDijagnoze().subscribe(
    //   data => {
    //     this.listaSvihDijagnoza = data;
    //   }
    // );
   }

  ngOnInit() {
  }

  onNgModelChange(event){
    this.odbraneDijagnoze = event;
  } 

  onNgModelChangeLek(event){
    this.odabraniLekovi = event;
  }

  dodajDijagnozeCBR(){
    this.upisiDijagnozeCBR(this.odbraneDijagnoze).subscribe(
      data => {
        this.listaLekova = data;
        console.log("CBR:");
        console.log(this.listaLekova);
      }
    );
  }

  dodajDijagnozeRBR(){
    this.upisiDijagnozeRBR(this.odbraneDijagnoze).subscribe(
      data => {
        this.listaLekova = data;
        console.log("RBR:");
        console.log(this.listaLekova);
      }
    );
  }

  sacuvajTerapiju(){
    this.pregled = this.model;
    this.pregled.dijagnoze = this.odbraneDijagnoze;
    this.pregled.lekovi = this.odabraniLekovi 
    this.saveLekove().subscribe(
      data => {
        console.log('Uspesno sacuvane dijagnoze.');
        this.dialogRef.close(this.pregled);
      }
    );
  } 


  // dobaviDijagnoze(): Observable<Dijagnoza[]>{
  //   return this.http.get<Dijagnoza[]>('http://localhost:8089/lek/getAllDijagnoza');
  // }

  validateSavucaj(){
    return this.odabraniLekovi.length!=0?true:false;
  }
  validatePronadji(){
    return this.odbraneDijagnoze.length!=0?true:false;
  }
  validateListuDijagnoza(){
    return this.listaSvihDijagnoza.length!=0?true:false;
  }
  getDijagnoze(){
    this.getAllDijagnoze().subscribe(dijagnoze =>{
      this.listaSvihDijagnoza = dijagnoze;
    })
  }
  getLekovi(){
    this.getAllLekovi().subscribe(lekovi =>{
      this.listaLekova = lekovi;
    })
  }

  upisiDijagnozeCBR(dijagnoze):Observable<any>{
    return this.http.post('http://localhost:8089/lek/cbr/' + this.pregled.id, dijagnoze);
  }
  upisiDijagnozeRBR(dijagnoze):Observable<any>{
    return this.http.post('http://localhost:8089/lek/rbr/' + this.pregled.id, dijagnoze);
  }
  saveLekove():Observable<any>{
    return this.http.post('http://localhost:8089/lek/lek/' + this.pregled.id, this.odabraniLekovi);
  }
  getAllDijagnoze(): Observable<Dijagnoza[]>{
    return this.http.get<Dijagnoza[]>('http://localhost:8089/dijagnoza');
  }
  getAllLekovi(): Observable<Dijagnoza[]>{
      return this.http.get<Lek[]>('http://localhost:8089/lek');
  }
}
