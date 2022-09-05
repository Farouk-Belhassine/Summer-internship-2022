import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProcedureService {

  readonly API_URL_PROCEDURE='http://localhost:8083/2k22internship/procedure';
  readonly API_URL_SEQUENCE='http://localhost:8083/2k22internship/sequence';
  readonly API_URL_STAGE='http://localhost:8083/2k22internship/stage';
  readonly API_URL_STEP='http://localhost:8083/2k22internship/step';
  readonly API_URL_EXEPROCEDURE='http://localhost:8083/2k22internship/exeProcedure';

  constructor(private httpClient: HttpClient) { }

  getAllProcedures(){
    return this.httpClient.get(`${this.API_URL_PROCEDURE}/getAllProcedures`);
  }

  addProcedure(procedure:any){
    return this.httpClient.post(`${this. API_URL_PROCEDURE}/addProcedure`, procedure);
  }

  updateProcedure(procedure:any){
    return this.httpClient.put(`${this.API_URL_PROCEDURE}/updateProcedure`, procedure);
  }
  deleteProcedure(id : any){
    return this.httpClient.delete(`${this.API_URL_PROCEDURE}/deleteProcedure/${id}`);
  }

  getProcedure(id : any){
    return this.httpClient.get(`${this.API_URL_PROCEDURE}/getProcedure/${id}`);
  }

  addSequence(procedureId : any){
    return this.httpClient.post(`${this. API_URL_PROCEDURE}/addSequence/${procedureId}`, null);
  }

  deleteSequence(procId : any, sequenceId : any){
    return this.httpClient.delete(`${this.API_URL_PROCEDURE}/deleteSequence/${procId},${sequenceId}`);
  }

  addStage(sequenceId : any){
    return this.httpClient.post(`${this. API_URL_SEQUENCE}/addStage/${sequenceId}`, null);
  }

  deleteStage(sequenceId : any, stageId : any){
    return this.httpClient.delete(`${this.API_URL_SEQUENCE}/deleteStage/${sequenceId},${stageId}`);
  }

  addStep(stageId : any){
    return this.httpClient.post(`${this. API_URL_STAGE}/addStep/${stageId}`, null);
  }

  deleteStep(stageId : any, stepId : any){
    return this.httpClient.delete(`${this.API_URL_STAGE}/deleteStep/${stageId},${stepId}`);
  }

  getStep(id : any){
    return this.httpClient.get(`${this.API_URL_STEP}/getStep/${id}`);
  }

  updateStep(step : any){
    return this.httpClient.put(`${this.API_URL_STEP}/updateStep`, step);
  }

  createXml(procId : any):Observable<any>{
    return this.httpClient.get(`${this.API_URL_PROCEDURE}/createXml/${procId}`/*,{observe:'response',responseType:'blob'}*/);
  }

  LoadProcedureFromXml(filee:any):Observable<any> {
    // Create form data
    const file = new FormData(); 
      
    // Store form name as "file" with file data
    file.append("file", filee, filee.name);
      
    // Make http post request over api
    // with formData as req
    return this.httpClient.post(`${this.API_URL_PROCEDURE}/LoadProcedureFromXml`, file)
  }

  execute(procId: any, comment: string){
    let params = new HttpParams();
    params = params.append('comment', comment);
    return this.httpClient.post(`${this. API_URL_EXEPROCEDURE}/affectProcedureToExec/${procId}`, params);
  }
}