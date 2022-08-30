import { Component, OnInit } from '@angular/core';

import { ExeProcedure } from './exec';
import { ExecService } from './exec.service';

@Component({
  selector: 'app-exec',
  templateUrl: './exec.component.html',
  styleUrls: ['./exec.component.css']
})
export class ExecComponent implements OnInit {

  listProcedures!: any;
  selectedProcedure!: any;
  selectedSequence!: any;
  selectedStage!: any;
  selectedStep!: any;
  comment!: string;
  
  constructor(private execService: ExecService) { }

  ngOnInit(): void {
    this.getAllProcedures();
    this.selectedProcedure = null;
  }

  getAllProcedures() {
    this.execService.getAllProcedures().subscribe(res => this.listProcedures = res)
  }

  onSelectProcedure(id: any): void {
    this.execService.getProcedure(id).subscribe(res => this.selectedProcedure = res);
    this.selectedSequence = null;
    this.selectedStage = null;
    this.selectedStep = null;
  }

  onSelectSequence(sequence: any): void {
    this.selectedSequence = sequence;
  }

  onSelectStage(stage: any): void {
    this.selectedStage = stage;
  }

  onSelectStep(step: any): void {
    this.selectedStep = step;
  }

  updateStep(stepp: any, comment: any) {
    const now = new Date();
    stepp.comment += "\n" + now.toUTCString() + ": " + comment;
    console.log(stepp.comment);

    this.execService.updateStep(stepp).subscribe();
    alert("Step updated succesfully");
  }

  backToStepSelection(){
    this.selectedStep = null;
  }

  backToStageSelection(){
    this.selectedStage = null;
  }

  backToSequenceSelection(){
    this.selectedSequence = null;
  }

  findNextStep(){
    if(this.selectedStep==null&&this.selectedStage.exeSteps[0]!=null) {
      this.selectedStep = this.selectedStage.exeSteps[0];
      return true;
    }
    else if(this.selectedStage.exeSteps[this.selectedStep.number]!=null){
      this.selectedStep = this.selectedStage.exeSteps[this.selectedStep.number];
      return true;
    }
    else {
      this.backToStepSelection();
      return false;
    }
  }

  findNextStage(){
    if(this.selectedStage==null&&this.selectedSequence.exeStages[0]!=null) {
      this.selectedStage = this.selectedSequence.exeStages[0];
      return true;
    }
    else if(this.selectedSequence.exeStages[this.selectedStage.number]!=null){
      this.selectedStage = this.selectedSequence.exeStages[this.selectedStage.number];
      this.findNextStep();
      return true;
    }
    else{
      this.backToStepSelection();
      this.backToStageSelection();
      return false;
    }
  }

  findNextSequence(){
    if(this.selectedSequence==null&&this.selectedProcedure.exeSequences[0]!=null) {
      this.selectedSequence = this.selectedProcedure.exeSequences[0];
    }
    else if(this.selectedProcedure.exeSequences[this.selectedSequence.number]!=null){
      this.selectedSequence = this.selectedProcedure.exeSequences[this.selectedSequence.number];
      this.findNextStage();
      this.findNextStep();
    }
    else {
      this.backToStepSelection();
      this.backToStageSelection();
      this.backToSequenceSelection();
    }
  }

  next(){
    if(!this.findNextStep()) if(!this.findNextStage()) this.findNextSequence();
  }

  findPreviousStep(){
    if(this.selectedStep==null&&this.selectedStage.exeSteps[0]!=null) {
      this.selectedStep = this.selectedStage.exeSteps[0];
      return true;
    }
    else if(this.selectedStage.exeSteps[this.selectedStep.number-2]!=null){
      this.selectedStep = this.selectedStage.exeSteps[this.selectedStep.number-2];
      return true;
    }
    else {
      this.backToStepSelection();
      return false;
    }
  }

  findPreviousStage(){
    if(this.selectedStage==null&&this.selectedSequence.exeStages[0]!=null) {
      this.selectedStage = this.selectedSequence.exeStages[0];
      return true;
    }
    else if(this.selectedSequence.exeStages[this.selectedStage.number-2]!=null){
      this.selectedStage = this.selectedSequence.exeStages[this.selectedStage.number-2];
      this.findPreviousStep();
      return true;
    }
    else{
      this.backToStepSelection();
      this.backToStageSelection();
      return false;
    }
  }

  findPreviousSequence(){
    if(this.selectedSequence==null&&this.selectedProcedure.exeSequences[0]!=null) {
      this.selectedSequence = this.selectedProcedure.exeSequences[0];
    }
    else if(this.selectedProcedure.exeSequences[this.selectedSequence.number-2]!=null){
      this.selectedSequence = this.selectedProcedure.exeSequences[this.selectedSequence.number-2];
      this.findPreviousStage();
      this.findPreviousStep();
    }
    else {
      this.backToStepSelection();
      this.backToStageSelection();
      this.backToSequenceSelection();
    }
  }

  back(){
    if(!this.findPreviousStep()) if(!this.findPreviousStage()) this.findPreviousSequence();
  }
}
