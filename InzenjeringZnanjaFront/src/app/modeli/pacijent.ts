import { ZdravstveniKarton } from './zdravstveni-karton';
export class Pacijent {
    id:number;
    name: string;
    lastname: string;
    karton: ZdravstveniKarton;
    pol: string;
    rasa: string;
}
