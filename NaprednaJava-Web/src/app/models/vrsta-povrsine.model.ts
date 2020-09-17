import { Povrsina } from './povrsina.model';
import { Prostorija } from './prostorija.model';

export class VrstaPovrsine {

    id: number;

    naziv: string;

    prostorije: Prostorija[];

    povrsine: Povrsina[];
}