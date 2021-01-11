import { Pacijent } from 'src/app/modeli/pacijent';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';

@Component({
  selector: 'app-pacijent-dialog',
  templateUrl: './pacijent-dialog.component.html',
  styleUrls: ['./pacijent-dialog.component.css']
})
export class PacijentDialogComponent implements OnInit {
  firstname:string="";
  lastname:string="";
  pol: string="";
  rasa: string="";
  pacijent: Pacijent = new Pacijent();
  flag:number;
  constructor(public dialogRef: MatDialogRef<PacijentDialogComponent>, @Inject(MAT_DIALOG_DATA) public model: any, private http: HttpClient) {
    this.flag = model.flag;
    if(this.flag == 2 || this.flag == 3){
      this.pacijent = model.data;
      this.firstname = model.data.name;
      this.lastname = model.data.lastname;
    }
   }

  ngOnInit() {
    console.log(this.model);
  }

  onSubmit(){
    console.log("Ime: " + this.firstname + " , Prezime: "+this.lastname);
    if(this.flag==1){
      this.upisiPacijenta().subscribe(pacijent => {
        this.dialogRef.close(pacijent);
      });
    } else if(this.flag==2){
      this.izmeniPacijenta().subscribe(pacijent => {
        this.dialogRef.close(pacijent);
      });
    } else if(this.flag==3){
      this.izbrisiPacijenta().subscribe(pacijent => {
        this.dialogRef.close(this.pacijent.id);
      });
    }
  }
  validateSubmit(){
    return this.firstname=="" || this.lastname=="" || this.pol=="" || this.rasa==""? false:true;
  }
  validateEditSubmit(){
    return this.firstname=="" || this.lastname==""? false:true;
  }

  unesiPacijent(){
    this.upisiPacijenta().subscribe(
      data => {
        console.log('Pacijent sacuvan!');
      }
    );
  }

  upisiPacijenta(){
    this.pacijent.name = this.firstname;
    this.pacijent.lastname = this.lastname;
    this.pacijent.pol = this.pol;
    this.pacijent.rasa = this.rasa;
    console.log('Pacijent je: ' + this.pacijent);
    return this.http.post('http://localhost:8089/pregled/karton', this.pacijent);
  }

  izmeniPacijenta(){
    this.pacijent.name = this.firstname;
    this.pacijent.lastname = this.lastname;
    console.log('Pacijent je: ' + this.pacijent);
    return this.http.put('http://localhost:8089/pregled/karton', this.pacijent);
  }

  izbrisiPacijenta(){
    return this.http.delete('http://localhost:8089/pregled/karton/'+this.pacijent.id);
  }
}
