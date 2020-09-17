import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
    providedIn: 'root'
})

export class AlertService {

    constructor(private toastr: ToastrService) { }

    showSuccess(message: string, title: string) {
        this.toastr.success(message, title);
    }

    showError(message: string, title: string) {
        this.toastr.error(message, title);
    }

    errorHandler(error: any) {
        if (error.status === 400) {
            this.showError(error.error.message, 'Error');
        }
        if (error.status === 404) {
            this.showError(error.error.message, 'Error');
        }
        if (error.status === 500) {
            this.showError(error.error.message, 'Error');
        }
    }
}
