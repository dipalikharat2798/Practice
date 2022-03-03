import { TestBed } from '@angular/core/testing';

import { MyserviceService } from './myservice.service';

describe('MyserviceService', () => {
  let service: MyserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it('Login Service Testing', () => {
    const subResult = service.checkusernameandpassword("admin","admin123");
    expect(subResult).toBe(true);
  });
});
