import { Routes } from '@angular/router';
import { Dashboard } from './dashboard/dashboard';
import { Transaction } from './transaction/transaction';
import { Loginform } from './loginform/loginform';

export const routes: Routes = [
  {
    path: '',
    component: Dashboard
  },
  {
    path: 'dashboard',
    component: Dashboard
  },
  {
    path: 'transaction',
    component: Transaction
  },
  {
    path:'login',
    component:Loginform
}
];