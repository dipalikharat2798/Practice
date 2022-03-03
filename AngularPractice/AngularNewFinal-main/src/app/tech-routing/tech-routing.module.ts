import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router'
import { WebComponent } from "src/app/web/web.component";
import { JavaComponent } from "src/app/java/java.component";
import { ProductComponent } from '../product/product.component';
import { EmployeeComponent } from '../employee/employee.component';
import { HomeComponent } from '../home/home.component';
import { CorejavaComponent } from '../corejava/corejava.component';
import { AdvjavaComponent } from '../advjava/advjava.component';
import { TempFormComponent } from '../temp-form/temp-form.component';
import { ModelFormsComponent } from '../model-forms/model-forms.component';
import { TechnologiesComponent } from '../technologies/technologies.component';
import { ReviewComponent } from '../review/review.component';
import { WebTechComponent } from '../web-tech/web-tech.component';
import { DotNetComponent } from '../dot-net/dot-net.component';
import { LoginComponent } from '../login/login.component';
import { AppComponent } from '../app.component';
import { RedirectComponent } from '../redirect/redirect.component';
import { AuthGuard } from '../auth.guard';
import { DashboardComponent } from '../dashboard/dashboard.component';

const routes: Routes = [
  { path: 'web', component: WebComponent },
  { path: 'app', component: AppComponent },
  { path: 'webtech', component: WebTechComponent },
  { path: 'dotnet', component: DotNetComponent },
  {
    path: 'java', component: JavaComponent,
    children: [
      { path: 'corejava', component: CorejavaComponent },
      { path: 'advjava', component: AdvjavaComponent },
    ]
  },
  { path: "dashboard", canActivate: [AuthGuard], component: HomeComponent },
  { path: "login", component: LoginComponent },
   { path: 'product', component: ProductComponent },
  { path: 'employee', component: EmployeeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'tforms', component: TempFormComponent },
  { path: 'mforms', component: ModelFormsComponent },
  { path: 'techno', component: TechnologiesComponent },
  { path: 'review', component: ReviewComponent },
  { path: 'Login', component: LoginComponent },
  //{ path: 'redirect', component: RedirectComponent },
  
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [RouterModule]
})
export class TechRoutingModule { }
export const routingComponents = [WebComponent, RedirectComponent, AppComponent,LoginComponent, ModelFormsComponent, WebTechComponent, DotNetComponent, ReviewComponent,TechnologiesComponent, JavaComponent, EmployeeComponent, ProductComponent, HomeComponent, CorejavaComponent, AdvjavaComponent, TempFormComponent]
