import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ProductService } from '../product.service';

import { ProductComponent } from './product.component';

describe('ProductComponent', () => {
  let component: ProductComponent;
  let fixture: ComponentFixture<ProductComponent>;
  let productService: ProductService;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('ProductServiceGetMethodCallingFormComp', () => {
    productService = TestBed.inject(ProductService);
    let result = []
    result = productService.getProducts();
    expect(result).toEqual(['mobile', 'tv', 'laptop']);
  });
  it('ProductServiceAddMethodCallingFormComp', () => {
    productService = TestBed.inject(ProductService);
    let prodResult: any = [];
    prodResult = productService.addProduct('refrigirator');
    expect(prodResult).toEqual(['mobile', 'tv', 'laptop', 'refrigirator']);
  })
});
