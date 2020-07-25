import { Component, OnInit } from '@angular/core';
import { UserService } from '../_services/user.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Product } from '../products/product';
import { ProductServices } from '../services/product.services';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  content: string;
  product: Product;
  products: Observable<Product[]>;
  private roles: string[];
  showModeratorBoard = false;

  constructor(private userService: UserService, private productServices: ProductServices, private router: Router, private tokenStorageService: TokenStorageService) { }
  ngOnInit() {
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
    const user = this.tokenStorageService.getUser();
    this.roles = user.roles;
    this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
    this.reloadData();
  }

  reloadData() {
    this.products = this.productServices.getProductsList();
  }

  deleteProduct(id: number) {
    this.productServices.deleteProduct(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  productDetails(id: number){
    this.router.navigate(['products/details', id]);
  }
  
  updateProduct(id:number){
    this.router.navigate(['products/update', id]);
  }
}
