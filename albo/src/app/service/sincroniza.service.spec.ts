import { TestBed } from '@angular/core/testing';

import { SincronizaService } from './sincroniza.service';

describe('SincronizaService', () => {
  let service: SincronizaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SincronizaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
