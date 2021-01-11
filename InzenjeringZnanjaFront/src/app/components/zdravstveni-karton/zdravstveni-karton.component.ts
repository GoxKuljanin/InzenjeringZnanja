import { PregledDialogComponent } from './pregled-dialog/pregled-dialog.component';
import { Component, OnInit, ViewChild } from '@angular/core';
import { UnesiTestoveDialogComponent } from './../unesi-testove-dialog/unesi-testove-dialog.component';
import { UnesiDijagnozeDialogComponent } from './../unesi-dijagnoze-dialog/unesi-dijagnoze-dialog.component';
import { UnesiSimptomeDialogComponent } from './../unesi-simptome-dialog/unesi-simptome-dialog.component';
import { ZdravstveniKarton } from './../../modeli/zdravstveni-karton';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { MatTableDataSource, MatDialog, MatPaginator, MatSort } from '@angular/material';
import { Pregled } from './../../modeli/pregled';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-zdravstveni-karton',
  templateUrl: './zdravstveni-karton.component.html',
  styleUrls: ['./zdravstveni-karton.component.css']
})
export class ZdravstveniKartonComponent implements OnInit {

  pregledi: Pregled[] = [];
  displayedColumns: string[] = ['id', 'simptomi','testovi','dijagnoze','lekovi'];
  dataSource ;
  idKartona;

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  constructor(private http: HttpClient, private route: ActivatedRoute, public dialog: MatDialog) { }

  ngOnInit() {
    this.idKartona = parseInt(this.route.snapshot.paramMap.get('id'));
    this.dobaviZdravstveneKartone(this.idKartona).subscribe(
      data => {
        console.log(data)
        this.pregledi = data.pregledi;
        this.dataSource = new MatTableDataSource<Pregled>(data.pregledi);
        this.dataSource.sort = this.sort;
        this.dataSource.paginator = this.paginator;
      }
    );
  }

  unesiSimptome(model){
    console.log(model)
    const dialogRef = this.dialog.open(UnesiSimptomeDialogComponent, {data: model});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    });
  }

  unesiDijagnoze(model){
    const dialogRef = this.dialog.open(UnesiDijagnozeDialogComponent, {data: model});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    });
  }

  unesiTestove(model){
    const dialogRef = this.dialog.open(UnesiTestoveDialogComponent, {data: model});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
    });
  }

  onNoviPregled(){
    let flag = 1;
    const dialogRef = this.dialog.open(PregledDialogComponent, {data: {id:this.idKartona,flag:flag}});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      this.pregledi.push(result);
      this.dataSource = new MatTableDataSource<Pregled>(this.pregledi);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  onDelete(pregled:Pregled){
    let flag = 2;
    const dialogRef = this.dialog.open(PregledDialogComponent, {data: {id:this.idKartona,flag:flag,idPregleda:pregled.id}});
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      this.pregledi.push(result);
      this.dataSource = new MatTableDataSource<Pregled>(this.pregledi);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  dobaviZdravstveneKartone(id: number):Observable<ZdravstveniKarton>{
    return this.http.get<ZdravstveniKarton>('http://localhost:8089/pregled/karton/' + id);
  }

  kreirajNoviPregled(id: number):Observable<any>{
    return this.http.put('http://localhost:8089/pregled', id);
  }
  simptomiValid(pregled:Pregled){
    return pregled.testovi.length!=0?true:false;
  }
  testoviValid(pregled:Pregled){ 
    return pregled.dijagnoze.length!=0?true:false;
  }
  dijagnozeValid(pregled:Pregled){
    return pregled.lekovi.length!=0?true:false;
  }
  lekoviValid(pregled:Pregled){
    return pregled.lekovi.length!=0?true:false;
  }
}
