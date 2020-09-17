import { IdejnoResenje } from './idejno-resenje.model';

export class Objekat {

    id: number;

    naziv: string;

    dimenzije: number;

    karakteristike: string;

    idejnaResenja: IdejnoResenje[];
}