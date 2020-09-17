import { Povrsina } from './povrsina.model';

export class ProjekatZaGradjevinskuDozvolu {

    id: number;

    naziv: string;

    datumIzrade: Date;

    idejnoResenjeId: number;

    povrsine: Povrsina[];

    statusDokumenta: StatusDokumenta;

    nazivIdejnogResenja: string;
}

export enum StatusDokumenta {

    Nov,

    Kreiran,

    Obradjen
}

export const STATUSIDOKUMENTA = [
    { id: 0, label: 'Nov' },
    { id: 1, label: 'Kreiran' },
    { id: 2, label: 'Obradjen' }
]