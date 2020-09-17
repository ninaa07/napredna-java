import { IdejnoResenje } from './idejno-resenje.model';

export class LokacijskaDozvola {

    id: number;

    naziv: string;

    opstiPodaci: string;

    lokacijskiUslovi: string;

    brojParcele: number;

    povrsinaParcele: number;

    datumIzdavanja: Date;

    informacijeOLokacijiId: number;

    nazivIdejnogResenja: string;

    idejnaResenja: IdejnoResenje[];
}