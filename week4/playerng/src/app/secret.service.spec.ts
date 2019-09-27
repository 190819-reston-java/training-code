import { TestBed } from '@angular/core/testing';

import { SecretService } from './secret.service';

describe('SecretService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SecretService = TestBed.get(SecretService);
    expect(service).toBeTruthy();
  });
});
