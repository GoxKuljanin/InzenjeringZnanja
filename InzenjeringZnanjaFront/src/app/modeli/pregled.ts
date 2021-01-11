import { ZdravstveniKarton } from './zdravstveni-karton';
import { Test } from './test';
import { Simptom } from './simptom';
import { Dijagnoza } from './dijagnoza.model';
import { Lek } from './lek.model';
export class Pregled {
    id:number;
    simptomi: Simptom[];
    testovi: Test[];
    dijagnoze: Dijagnoza[];
    lekovi: Lek[];
}
