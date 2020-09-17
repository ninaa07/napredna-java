import { ProjekatZaGradjevinskuDozvolu } from './projekat-za-gradjevinsku-dozvolu.model';

export class IdejnoResenje {

    id: number;

    naziv: string;

    datumIzrade: Date;

    glavniProjektantId: number;

    objekatId: number;

    lokacijskaDozvolaId: number;

    projektiZaGradjevinskuDozvolu: ProjekatZaGradjevinskuDozvolu[];
}