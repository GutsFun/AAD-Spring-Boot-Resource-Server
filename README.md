# AAD-Spring-Boot-Resource-Server

> 📃 Cette API est utilisée dans le cadre d'un article disponible depuis mon blog technique :
https://developer.gutsfun.com/utiliser-les-roles-dazure-active-directory-avec-une-web-api-sous-spring-boot-pour-authentifier-les-utilisateurs/

Cet exemple vous montre de quelle manière il faut utiliser la dépendance d'Azure Active Directory pour
sécuriser les accès de l'API Java à l'aide des rôles applicatifs configurés depuis les
groupes Azure AD d'une organisation.

Vos contrôleurs peuvent ainsi être annotés de la manière suivante pour sécuriser leurs accès :
```java
@GetMapping("user")
@PreAuthorize("hasRole('ROLE_User')")
public AADOAuth2AuthenticatedPrincipal getUserPrincipal(Authentication authentication) {
  LOGGER.info("User has access");
  return (AADOAuth2AuthenticatedPrincipal) authentication.getPrincipal();
}
```

Pensez à bien modifier le fichier d'environnement ***application.yml*** pour qu'il corresponde aux identifiants
déclarés depuis votre compte Azure Active Directory :
```yaml
azure:
  activedirectory:
    client-id: <Replace-with-your-WebApp-Client-ID>
    app-id-uri: <Replace-with-your-WebApi-URI-application-ID>
```


