import { TestBed } from '@angular/core/testing';

import { MovieHttpService } from './movie-http.service';

describe('MovieHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MovieHttpService = TestBed.get(MovieHttpService);
    expect(service).toBeTruthy();
  });
});
