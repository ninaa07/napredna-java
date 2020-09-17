import { IdejnoResenje } from './idejno-resenje.model';

export class GlavniProjektant {

    id: number;

    imePrezime: string;

    brojLicence: number;

    zvanje: string;

    idejnaResenja: IdejnoResenje[];
}