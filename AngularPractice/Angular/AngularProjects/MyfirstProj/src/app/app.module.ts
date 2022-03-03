import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { CustomerComponent } from './customer/customer.component';
import { ProductComponent } from './product/product.component';
import { PropBindComponent } from './prop-bind/prop-bind.component';
import { EventbindComponent } from './eventbind/eventbind.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { InterpolationComponent } from './interpolation/interpolation.component';
import { StructDirComponent } from './struct-dir/struct-dir.component';
import { StructDirobjComponent } from './struct-dirobj/struct-dirobj.component';
import { DisplayProductComponent } from './display-product/display-product.component';
import { SwitchComponent } from './switch/switch.component';
import { SecondDirDirective } from './second-dir.directive';
import { AttributeComponent } from './attribute/attribute.component';
import { NewdirDirective } from './newdir.directive';
import { PipeComponent } from './pipe/pipe.component';
import { ReverseStringPipe } from './reverse-string.pipe';
import { SortPipe } from './sort.pipe';
import { SearchPipe } from './search.pipe';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { EmpDetailsComponent } from './emp-details/emp-details.component';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';
import { ProductChildComponent } from './product-child/product-child.component';
import { ProductParentComponent } from './product-parent/product-parent.component';
import { FirstComponent } from './first/first.component';
import { SecondComponent } from './second/second.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    CustomerComponent,
    ProductComponent,
    PropBindComponent,
    EventbindComponent,
    CalculatorComponent,
    InterpolationComponent,
    StructDirComponent,
    StructDirobjComponent,
    DisplayProductComponent,
    SwitchComponent,
   
    SecondDirDirective,
 
    AttributeComponent,
 
    NewdirDirective,
 
    PipeComponent,
 
    ReverseStringPipe,
 
    SortPipe,
 
    SearchPipe,
 
    EmpDetailsComponent,
 
    ParentComponent,
 
    ChildComponent,
 
    ProductChildComponent,
 
    ProductParentComponent,
 
    FirstComponent,
 
    SecondComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
