import { AbstractControl } from '@angular/forms';

export function MyValidator(control: AbstractControl) {
  if (!control.value.startsWith('https') || !control.value.includes('.io')) {
    return {'invalid id': true };
  }
  return null;
}