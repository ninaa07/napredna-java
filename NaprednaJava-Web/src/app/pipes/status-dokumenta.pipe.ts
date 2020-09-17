import { Pipe, PipeTransform } from '@angular/core';
import { STATUSIDOKUMENTA, StatusDokumenta } from '../models/projekat-za-gradjevinsku-dozvolu.model';

@Pipe({ name: 'statusDokumentaPipe' })
export class StatusDokumentaPipe implements PipeTransform {

  statuses = STATUSIDOKUMENTA;

  transform(value: number, exponent?: number): string {
    return this.getStatus(value);
  }

  getStatus(status: StatusDokumenta): string {
    return this.statuses.find(x => x.id === status).label;
  }
}
