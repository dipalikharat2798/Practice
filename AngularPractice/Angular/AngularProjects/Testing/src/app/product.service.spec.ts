import { TestBed } from '@angular/core/testing';

import { ProductService } from './product.service';

describe('ProductService', () => {
  let service: ProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it('get Products', () => {
    let result = []
    result = service.getProducts();
    expect(result).toEqual(['mobile', 'tv', 'laptop']);
  });
  it('Add Products', () => {
    service = TestBed.inject(ProductService);
    let prodResult: any = [];
    prodResult = service.addProduct('refrigirator');
    expect(prodResult).toEqual(['mobile', 'tv', 'laptop', 'refrigirator']);
  })
});
