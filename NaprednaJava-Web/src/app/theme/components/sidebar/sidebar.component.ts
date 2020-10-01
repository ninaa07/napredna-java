import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  // {
  //   path: '/pregled',
  //   title: 'Pregled',
  //   icon: 'icon-puzzle-10',
  //   class: '',
  // },
  {
    path: '/prosti',
    title: 'Prosti',
    icon: 'icon-puzzle-10',
    class: ''
  },
  {
    path: '/slozeni',
    title: 'Složeni',
    icon: 'icon-puzzle-10',
    class: ''
  },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if (window.innerWidth > 991) {
      return false;
    }
    return true;
  }
}
