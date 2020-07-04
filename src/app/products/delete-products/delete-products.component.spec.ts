import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteProductsComponent } from './delete-products.component';

describe('DeleteProductsComponent', () => {
  let component: DeleteProductsComponent;
  let fixture: ComponentFixture<DeleteProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeleteProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
