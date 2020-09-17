import { LokacijskaDozvola } from './lokacijska-dozvola.model';

export class InformacijeOLokaciji {

    id: number;

    naziv: string;

    datumIzdavanja: Date;

    namenaZemljista: string;

    zona: string;

    lokacijskeDozvole: LokacijskaDozvola[];
}