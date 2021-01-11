import { Simptom } from './../../modeli/simptom';
import { UnesiSimptomeDialogComponent } from './../unesi-simptome-dialog/unesi-simptome-dialog.component';
import { Pacijent } from './../../modeli/pacijent';
import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { MatDialog, MatTableDataSource, MatPaginator, MatSort } from '@angular/material';
import { UnesiDijagnozeDialogComponent } from '../unesi-dijagnoze-dialog/unesi-dijagnoze-dialog.component';
import { UnesiTestoveDialogComponent } from '../unesi-testove-dialog/unesi-testove-dialog.component';
import { Router } from '@angular/router';
import { PacijentDialogComponent } from './pacijent-dialog/pacijent-dialog.component';

@Component({
  selector: 'app-pacijenti',
  templateUrl: './pacijenti.component.html',
  styleUrls: ['./pacijenti.component.css']
})

export class PacijentiComponent implements OnInit {

  pacijenti: Pacijent[] = [];
  displayedColumns: string[] = ['id', 'name', 'lastname', 'karton',' '];
  dataSource = new MatTableDataSource<Pacijent>(this.pacijenti);
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  constructor(private http: HttpClient, public dialog: MatDialog, private router: Router) { }

  ngOnInit() {
    let res = this.dobaviPacijente().subscribe(
      data => {
        this.pacijenti = data;
        console.log(data);
        this.dataSource = new MatTableDataSource<Pacijent>(this.pacijenti);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator; 
      }
    );
  } 

  onKarton(model){
    let pacij : Pacijent = new Pacijent();
    pacij.id = (model as Pacijent).id;
    console.log(model);
    this.router.navigateByUrl('karton/' + model.karton.id);
  }
  onEdit(model){
    let flag :number = 2;
    const dialogRef = this.dialog.open(PacijentDialogComponent,{data: { data: model, flag: flag}});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    });
  }
  onDelete(model){
    let flag :number = 3;
    const dialogRef = this.dialog.open(PacijentDialogComponent,{data: { data: model, flag: flag}});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      let noviNiz: Pacijent[]=[];
      for(let pacijent of this.pacijenti){
        pacijent.id!=result?noviNiz.push(pacijent):null;
      }
      this.pacijenti=noviNiz;
      this.dataSource = new MatTableDataSource<Pacijent>(this.pacijenti);
      this.dataSource.paginator = this.paginator;
    });
  }

  onNoviPacijent(){
    let flag :number = 1;
    const dialogRef = this.dialog.open(PacijentDialogComponent,{data: { flag: flag}});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if((result as Pacijent).id>=1){
        console.log("Rodja");
        console.log(result);
        this.pacijenti.unshift(result);
        this.dataSource = new MatTableDataSource<Pacijent>(this.pacijenti);
        this.dataSource.paginator = this.paginator;
      }
    });
  }

  dobaviPacijente(): Observable<Pacijent[]>{
    return this.http.get<Pacijent[]>('http://localhost:8089/pregled/pacijent');
  } 
}
