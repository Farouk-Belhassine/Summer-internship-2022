import { Component, OnInit } from '@angular/core';
import * as fileSaver from 'file-saver';

import { Procedure } from './procedure';
import { ProcedureService } from './procedure.service';

@Component({
  selector: 'app-procedure',
  templateUrl: './procedure.component.html',
  styleUrls: ['./procedure.component.css']
})
export class ProcedureComponent implements OnInit {

  selectedProcedure!: any;
  listProcedures: any;
  procedure!: any;
  selectedStep!: any;
  file!: File;
  LoadFromFile!: any;
  comment!: string;

  constructor(private procedureService: ProcedureService) { }


  ngOnInit(): void {
    this.getAllProcedures();

    this.procedure = {
      id: null,
      name: null
    }
  }

  getAllProcedures() {
    this.procedureService.getAllProcedures().subscribe(res => this.listProcedures = res)
  }

  addProcedure(p: any) {
    this.procedureService.addProcedure(p).subscribe(() => {
      this.getAllProcedures();
    });
  }

  updateProcedure(p: Procedure) {
    this.procedureService.updateProcedure(p).subscribe();
  }

  deleteProcedure(id: any) {
    this.selectedProcedure = null;
    this.procedureService.deleteProcedure(id).subscribe(() => this.getAllProcedures());
  }

  onSelectProcedure(id: any): void {
    this.procedureService.getProcedure(id).subscribe(res => this.selectedProcedure = res);
    this.selectedStep = null;
  }

  addSequence(procId: any) {
    this.procedureService.addSequence(procId).subscribe(() => {
      this.onSelectProcedure(procId);
    });
  }

  deleteSequence(procId: any, sequenceId: any) {
    this.procedureService.deleteSequence(procId, sequenceId).subscribe(() => this.onSelectProcedure(procId));
  }

  addStage(sequenceId: any, procId: any) {
    this.procedureService.addStage(sequenceId).subscribe(() => {
      this.onSelectProcedure(procId);
    });
  }

  deleteStage(sequenceId: any, stageId: any, procId: any) {
    this.procedureService.deleteStage(sequenceId, stageId).subscribe(() => this.onSelectProcedure(procId));
  }

  addStep(stageId: any, procId: any) {
    this.procedureService.addStep(stageId).subscribe(() => {
      this.onSelectProcedure(procId);
    });
  }

  deleteStep(stageId: any, stepId: any, procId: any) {
    this.procedureService.deleteStep(stageId, stepId).subscribe(() => this.onSelectProcedure(procId));
    this.selectedStep = null;
  }

  onSelectStep(id: any): void {
    if (!this.selectedStep || this.selectedStep.id != id) this.procedureService.getStep(id).subscribe(res => this.selectedStep = res);
    else this.selectedStep = null;
  }

  updateStep(stepp: any) {
    this.procedureService.updateStep(stepp).subscribe();
  }

  clearStep() {
    this.selectedStep.description = null;
    this.selectedStep.comment = null;
  }

  LFF(value: any){
    this.LoadFromFile=value;
  }

  FileGrabber(event: any) {
    this.file = event.target.files[0];
  }

  LoadProcedureFromXml() {
    this.procedureService.LoadProcedureFromXml(this.file).subscribe(() => this.getAllProcedures());
    this.LoadFromFile=null;
  }

  createXml(procId: any){
    this.procedureService.createXml(procId).subscribe((response: any) => {
			let blob:any = new Blob([response], {type:'text/xml'});
			const url = window.URL.createObjectURL(blob);
			fileSaver.saveAs(blob, 'procedure.xml');
			})
  }

  execute(procId: any, comment: any){
    this.procedureService.execute(procId,comment).subscribe();
  }
}
