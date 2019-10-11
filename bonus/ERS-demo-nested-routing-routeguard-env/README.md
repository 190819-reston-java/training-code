# Notes on Development

I've been playing with what I want to do with modules.  For now :
- shared : common importing, including a material submodule
- core : core functionality like Http stuff, reimbursement info and forms, tables, navbar, authorization
- employee : component pages specific to employees, includes its layout, lazy loaded
- manager : component pages specific to managers, includes its layout, lazy loaded
- public :  component pages available to the public and assoc. login service

Layout and routing happens via a naked router outlet in the bootstrapped app-module that provides routes to
lazily-loaded public, employee, and manager modules.  Each of these has its own layout and its own internal routing.

# ERSNg

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.8.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
