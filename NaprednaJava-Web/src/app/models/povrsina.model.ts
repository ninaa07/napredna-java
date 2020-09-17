import { VrstaPovrsine } from './vrsta-povrsine.model';

export class Povrsina {

    id: number;

    oznaka: number;

    naziv: string;

    vrstaPoda: string;

    projekatZaGradjevinskuDozvoluId: number;

    vrstaPovrsineId: number;

    vrstaPovrsine: VrstaPovrsine;

    prostorijaNaziv: string;

    status: Status;

    isEditable: boolean;
}

export enum Status {
    None,

    Insert,

    Update,

    Delete
}