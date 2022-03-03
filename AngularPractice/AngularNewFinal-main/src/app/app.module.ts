import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { WebComponent } from './web/web.component';
import { JavaComponent } from './java/java.component';
import { routingComponents, TechRoutingModule } from './tech-routing/tech-routing.module';
import { EmployeeComponent } from './employee/employee.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProductComponent } from './product/product.component';
import { HomeComponent } from './home/home.component';
import { SearchPipe } from './search.pipe';
import { SortPipe } from './sort.pipe';
import { CorejavaComponent } from './corejava/corejava.component';
import { AdvjavaComponent } from './advjava/advjava.component';
import { TempFormComponent } from './temp-form/temp-form.component';
import { ModelFormsComponent } from './model-forms/model-forms.component';
import { TrialComponent } from './trial/trial.component';
import { TechnologiesComponent } from './technologies/technologies.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { ReviewComponent } from './review/review.component';
import { TestComponent } from './test/test.component';
import { WebTechComponent } from './web-tech/web-tech.component';
import { DotNetComponent } from './dot-net/dot-net.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RedirectComponent } from './redirect/redirect.component';
import { AuthGuardComponent } from './auth-guard/auth-guard.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './auth.guard';
import { AppdirDirective } from './appdir.directive';
import { AppSecondDirDirective } from './app-second-dir.directive';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { HttpClient, HttpClientModule } from '@angular/common/http';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json')
}
@NgModule({
  declarations: [
    AppComponent,
    WebComponent,
    JavaComponent,
    routingComponents,
    EmployeeComponent,
   
    ProductComponent,
   
    HomeComponent,
   
    SearchPipe,
   
    SortPipe,
   
    CorejavaComponent,
   
    AdvjavaComponent,
   
    TempFormComponent,
   
    ModelFormsComponent,
   
    TrialComponent,
   
    TechnologiesComponent,
   
    NavbarComponent,
   
    FooterComponent,
   
    ReviewComponent,
   
    TestComponent,
   
    WebTechComponent,
   
    DotNetComponent,
   
    LoginComponent,
   
    LogoutComponent,
   
    RedirectComponent,
   
    AuthGuardComponent,
   
    DashboardComponent,
   
    AppdirDirective,
   
    AppSecondDirDirective
   
  ],
  imports: [
    BrowserModule, TechRoutingModule, FormsModule, HttpClientModule, ReactiveFormsModule, HttpClientModule, TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    })
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
