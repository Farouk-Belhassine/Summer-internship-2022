import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExecService {

  readonly API_URL_PROCEDURE='http://localhost:8083/condorweb/exeProcedure';
  readonly API_URL_STEP='http://localhost:8083/condorweb/exeStep';

  constructor(private httpClient: HttpClient) { }

  getAllProcedures(){
    return this.httpClient.get(`${this.API_URL_PROCEDURE}/getAllExeProcedures`);
  }

  getProcedure(id : any){
    return this.httpClient.get(`${this.API_URL_PROCEDURE}/getProcedure/${id}`);
  }

  getStep(id : any){
    return this.httpClient.get(`${this.API_URL_STEP}/getExeStep/${id}`);
  }

  updateStep(step : any){
    return this.httpClient.put(`${this.API_URL_STEP}/updateExeStep`, step);
  }
}
