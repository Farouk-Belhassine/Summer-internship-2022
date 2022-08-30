import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProcedureComponent } from './procedure/procedure.component';
import { ExecComponent } from './exec/exec.component';

const routes: Routes = [
  { path: '',   redirectTo: 'exec', pathMatch: 'full' },
  { path: 'procedure', component: ProcedureComponent },
  { path: 'exec', component: ExecComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
